package org.bouncycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.SignedData;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509StreamParserSpi;
import org.bouncycastle.x509.X509V2AttributeCertificate;
import org.bouncycastle.x509.util.StreamParsingException;

public class X509AttrCertParser extends X509StreamParserSpi {
    private static final PEMUtil PEM_PARSER;
    private InputStream currentStream;
    private ASN1Set sData;
    private int sDataObjectCount;

    static {
        PEM_PARSER = new PEMUtil("ATTRIBUTE CERTIFICATE");
    }

    public X509AttrCertParser() {
        this.sData = null;
        this.sDataObjectCount = 0;
        this.currentStream = null;
    }

    private X509AttributeCertificate getCertificate() {
        if (this.sData != null) {
            while (this.sDataObjectCount < this.sData.size()) {
                ASN1Set aSN1Set = this.sData;
                int i = this.sDataObjectCount;
                this.sDataObjectCount = i + 1;
                ASN1Encodable objectAt = aSN1Set.getObjectAt(i);
                if ((objectAt instanceof ASN1TaggedObject) && ((ASN1TaggedObject) objectAt).getTagNo() == 2) {
                    return new X509V2AttributeCertificate(ASN1Sequence.getInstance((ASN1TaggedObject) objectAt, false).getEncoded());
                }
            }
        }
        return null;
    }

    private X509AttributeCertificate readDERCertificate(InputStream inputStream) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(inputStream).readObject();
        if (aSN1Sequence.size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return new X509V2AttributeCertificate(aSN1Sequence.getEncoded());
        }
        this.sData = new SignedData(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCertificates();
        return getCertificate();
    }

    private X509AttributeCertificate readPEMCertificate(InputStream inputStream) {
        ASN1Sequence readPEMObject = PEM_PARSER.readPEMObject(inputStream);
        return readPEMObject != null ? new X509V2AttributeCertificate(readPEMObject.getEncoded()) : null;
    }

    public void engineInit(InputStream inputStream) {
        this.currentStream = inputStream;
        this.sData = null;
        this.sDataObjectCount = 0;
        if (!this.currentStream.markSupported()) {
            this.currentStream = new BufferedInputStream(this.currentStream);
        }
    }

    public Object engineRead() {
        try {
            if (this.sData == null) {
                this.currentStream.mark(10);
                int read = this.currentStream.read();
                if (read == -1) {
                    return null;
                }
                if (read != 48) {
                    this.currentStream.reset();
                    return readPEMCertificate(this.currentStream);
                }
                this.currentStream.reset();
                return readDERCertificate(this.currentStream);
            } else if (this.sDataObjectCount != this.sData.size()) {
                return getCertificate();
            } else {
                this.sData = null;
                this.sDataObjectCount = 0;
                return null;
            }
        } catch (Throwable e) {
            throw new StreamParsingException(e.toString(), e);
        }
    }

    public Collection engineReadAll() {
        Collection arrayList = new ArrayList();
        while (true) {
            X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) engineRead();
            if (x509AttributeCertificate == null) {
                return arrayList;
            }
            arrayList.add(x509AttributeCertificate);
        }
    }
}
