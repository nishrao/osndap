package io.osndap.tftp.protocol.packet;

import lombok.NonNull;

public enum TftpMode {
    netascii, octet, mail;

    public static TftpMode forMode(@NonNull String mode) {
        return TftpMode.valueOf(mode);
    }
}
