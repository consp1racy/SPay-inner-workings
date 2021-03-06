package org.bouncycastle.pqc.math.linearalgebra;

import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;

public final class BigEndianConversions {
    private BigEndianConversions() {
    }

    public static void I2OSP(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        i3 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
    }

    public static void I2OSP(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            bArr[i2 + i4] = (byte) (i >>> (((i3 - 1) - i4) * 8));
        }
    }

    public static void I2OSP(long j, byte[] bArr, int i) {
        int i2 = i + 1;
        bArr[i] = (byte) ((int) (j >>> 56));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j >>> 48));
        i2 = i3 + 1;
        bArr[i3] = (byte) ((int) (j >>> 40));
        i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j >>> 32));
        i2 = i3 + 1;
        bArr[i3] = (byte) ((int) (j >>> 24));
        i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j >>> 16));
        i2 = i3 + 1;
        bArr[i3] = (byte) ((int) (j >>> 8));
        bArr[i2] = (byte) ((int) j);
    }

    public static byte[] I2OSP(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    public static byte[] I2OSP(int i, int i2) {
        if (i < 0) {
            return null;
        }
        int ceilLog256 = IntegerFunctions.ceilLog256(i);
        if (ceilLog256 > i2) {
            throw new ArithmeticException("Cannot encode given integer into specified number of octets.");
        }
        byte[] bArr = new byte[i2];
        for (int i3 = i2 - 1; i3 >= i2 - ceilLog256; i3--) {
            bArr[i3] = (byte) (i >>> (((i2 - 1) - i3) * 8));
        }
        return bArr;
    }

    public static byte[] I2OSP(long j) {
        return new byte[]{(byte) ((int) (j >>> 56)), (byte) ((int) (j >>> 48)), (byte) ((int) (j >>> 40)), (byte) ((int) (j >>> 32)), (byte) ((int) (j >>> 24)), (byte) ((int) (j >>> 16)), (byte) ((int) (j >>> 8)), (byte) ((int) j)};
    }

    public static int OS2IP(byte[] bArr) {
        int i = 0;
        if (bArr.length > 4) {
            throw new ArithmeticException("invalid input length");
        } else if (bArr.length == 0) {
            return 0;
        } else {
            int i2 = 0;
            while (i < bArr.length) {
                i2 |= (bArr[i] & GF2Field.MASK) << (((bArr.length - 1) - i) * 8);
                i++;
            }
            return i2;
        }
    }

    public static int OS2IP(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((((bArr[i2] & GF2Field.MASK) << 16) | ((bArr[i] & GF2Field.MASK) << 24)) | ((bArr[i3] & GF2Field.MASK) << 8)) | (bArr[i3 + 1] & GF2Field.MASK);
    }

    public static int OS2IP(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (bArr.length != 0 && bArr.length >= (i + i2) - 1) {
            int i4 = 0;
            while (i4 < i2) {
                int i5 = ((bArr[i + i4] & GF2Field.MASK) << (((i2 - i4) - 1) * 8)) | i3;
                i4++;
                i3 = i5;
            }
        }
        return i3;
    }

    public static long OS2LIP(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        i2 = i3 + 1;
        i3 = i2 + 1;
        i2 = i3 + 1;
        i3 = i2 + 1;
        return ((long) (bArr[i3 + 1] & GF2Field.MASK)) | ((((((((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i2]) & 255) << 48)) | ((((long) bArr[i3]) & 255) << 40)) | ((((long) bArr[i2]) & 255) << 32)) | ((((long) bArr[i3]) & 255) << 24)) | ((long) ((bArr[i2] & GF2Field.MASK) << 16))) | ((long) ((bArr[i3] & GF2Field.MASK) << 8)));
    }

    public static byte[] toByteArray(int[] iArr) {
        byte[] bArr = new byte[(iArr.length << 2)];
        for (int i = 0; i < iArr.length; i++) {
            I2OSP(iArr[i], bArr, i << 2);
        }
        return bArr;
    }

    public static byte[] toByteArray(int[] iArr, int i) {
        int i2 = 0;
        int length = iArr.length;
        byte[] bArr = new byte[i];
        int i3 = 0;
        while (i2 <= length - 2) {
            I2OSP(iArr[i2], bArr, i3);
            i2++;
            i3 += 4;
        }
        I2OSP(iArr[length - 1], bArr, i3, i - i3);
        return bArr;
    }

    public static int[] toIntArray(byte[] bArr) {
        int i = 0;
        int length = (bArr.length + 3) / 4;
        int length2 = bArr.length & 3;
        int[] iArr = new int[length];
        int i2 = 0;
        while (i <= length - 2) {
            iArr[i] = OS2IP(bArr, i2);
            i++;
            i2 += 4;
        }
        if (length2 != 0) {
            iArr[length - 1] = OS2IP(bArr, i2, length2);
        } else {
            iArr[length - 1] = OS2IP(bArr, i2);
        }
        return iArr;
    }
}
