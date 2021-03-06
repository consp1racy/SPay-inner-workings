package com.sec.android.app.IWSpeechRecognizer;

public class CommandLanguage {
    public static final String[][] ALARM;
    public static final String[][] CALL;
    public static final String[][] CAMERA;
    public static final String[][] CANCEL;
    public static final String[][] MUSIC;

    static {
        r0 = new String[15][];
        r0[0] = new String[]{"수신", "거절"};
        r0[1] = new String[]{"Answer", "Reject"};
        r0[2] = new String[]{"接听", "拒绝"};
        r0[3] = new String[]{"Responder", "Rechazar"};
        r0[4] = new String[]{"Répondre", "Refuser"};
        r0[5] = new String[]{"Antworten", "Abweisen"};
        r0[6] = new String[]{"Rispondi", "Rifiuta"};
        r0[7] = new String[]{"応答", "拒否"};
        r0[8] = new String[]{"Ответить", "Отклонить"};
        r0[9] = new String[]{"Atender", "Recusar"};
        r0[10] = new String[]{"Answer", "Reject"};
        r0[11] = new String[]{"Responder", "Rechazar"};
        r0[12] = new String[]{"接通", "挂斷"};
        r0[13] = new String[]{"聽電話", "唔聽"};
        r0[14] = new String[]{"听电话", "唔听"};
        CALL = r0;
        r0 = new String[15][];
        r0[0] = new String[]{"중지", "다시 알림"};
        r0[1] = new String[]{"Stop", "Snooze"};
        r0[2] = new String[]{"停止", "重响"};
        r0[3] = new String[]{"Parar", "Repetir"};
        r0[4] = new String[]{"Arrêter", "Répéter"};
        r0[5] = new String[]{"Stopp", "Erinnern"};
        r0[6] = new String[]{"Stop", "Dopo"};
        r0[7] = new String[]{"ストップ", "スヌーズ"};
        r0[8] = new String[]{"Остановить", "Отложить"};
        r0[9] = new String[]{"Soneca", "Próxima"};
        r0[10] = new String[]{"Stop", "Snooze"};
        r0[11] = new String[]{"Parar", "Repetir"};
        r0[12] = new String[]{"關閉", "貪睡"};
        r0[13] = new String[]{"關閉", "響多次"};
        r0[14] = new String[]{"关闭", "响多次"};
        ALARM = r0;
        r0 = new String[15][];
        r0[0] = new String[]{"다음", "이전", "일시 정지", "재생", "소리 크게", "소리 작게"};
        r0[1] = new String[]{"Next", "Previous", "Pause", "Play", "Volume Up", "Volume Down"};
        r0[2] = new String[]{"下一首", "上一首", "暂停", "播放", "增大音量", "减小音量"};
        r0[3] = new String[]{"Siguiente", "Anterior", "Pausa", "Reproducir", "Subir Volumen", "Bajar Volumen"};
        r0[4] = new String[]{"Suivant", "Précédent", "Pause", "Lire", "Augmenter le Volume", "Baisser le Volume"};
        r0[5] = new String[]{"Weiter", "Vorherige", "Pause", "Wiedergabe", "Lauter", "Leiser"};
        r0[6] = new String[]{"Successivo", "Precedente", "Pausa", "Riproduci", "Aumenta Volume", "Abbassa Volume"};
        r0[7] = new String[]{"次", "前", "一時停止", "再生", "音量アップ", "音量ダウン"};
        r0[8] = new String[]{"Вперед", "Назад", "Пауза", "Играть", "Громче", "Тише"};
        r0[9] = new String[]{"Próxima", "Anterior", "Pausar", "Reproduzir", "Aumentar Volume", "Diminuir Volume"};
        r0[10] = new String[]{"Next", "Previous", "Pause", "Play", "Volume Up", "Volume Down"};
        r0[11] = new String[]{"Siguiente", "Anterior", "Pausa", "Reproducir", "Subir Volumen", "Bajar Volumen"};
        r0[12] = new String[]{"下首", "上首", "暫停", "開始", "放大", "減輕"};
        r0[13] = new String[]{"下一首", "上一首", "暫停", "播放", "大聲", "細聲"};
        r0[14] = new String[]{"下一首", "上一首", "暂停", "播放", "大声", "细声"};
        MUSIC = r0;
        r0 = new String[15][];
        r0[0] = new String[]{"스마일", "김치", "촬영", "찰칵", "동영상 촬영"};
        r0[1] = new String[]{"Smile", "Cheese", "Capture", "Shoot", "Record Video"};
        r0[2] = new String[]{"微笑", "茄子", "拍摄", "拍照", "录制视频"};
        r0[3] = new String[]{"Sonrisa", "Patata", "Capturar", "Disparar", "Grabar vídeo"};
        r0[4] = new String[]{"Sourire", "Cheese", "Capture", "Shooter", "Enregistrer une vidéo"};
        r0[5] = new String[]{"Lächeln", "Bitte Lächeln", "Klick", "Aufnahme", "Video aufnehmen"};
        r0[6] = new String[]{"Sorriso", "Cheese", "Cattura", "Scatta", "Registra"};
        r0[7] = new String[]{"スマイル", "チーズ", "撮影", "はいチーズ", "録画"};
        r0[8] = new String[]{"Сфотографировать", "Снять", "Улыбнитесь", "снимаю", "Запись видео"};
        r0[9] = new String[]{"Sorria", "Diga xis", "Capturar", "Disparar", "Gravar Vídeo"};
        r0[10] = new String[]{"Smile", "Cheese", "Capture", "Shoot", "Record Video"};
        r0[11] = new String[]{"Sonrisa", "Patata", "Capturar", "Disparar", "Grabar Vídeo"};
        r0[12] = new String[]{"笑一個", "Cheese", "攝影", "照相", "錄製影片"};
        r0[13] = new String[]{"笑一笑", "Cheese", "攝影", "影相", "錄影"};
        r0[14] = new String[]{"笑一笑", "Cheese", "摄影", "影相", "录影"};
        CAMERA = r0;
        r0 = new String[15][];
        r0[0] = new String[]{"취소"};
        r0[1] = new String[]{"Cancel"};
        r0[2] = new String[]{"取消"};
        r0[3] = new String[]{"Cancelar"};
        r0[4] = new String[]{"Annuler"};
        r0[5] = new String[]{"Abbrechen"};
        r0[6] = new String[]{"Annulla"};
        r0[7] = new String[]{"キャンセル"};
        r0[8] = new String[]{"Отмена"};
        r0[9] = new String[]{"Cancelar"};
        r0[10] = new String[]{"Cancel"};
        r0[11] = new String[]{"Cancelar"};
        r0[12] = new String[]{"退出"};
        r0[13] = new String[]{"取消"};
        r0[14] = new String[]{"取消"};
        CANCEL = r0;
    }
}
