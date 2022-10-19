package io.osndap.tftp.protocol.packet;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public enum TftpOptionType {
    blksize, timeout,tsize;

    @NonNull
    public static TftpOptionType forOpType(@NonNull String opType) {
        return TftpOptionType.valueOf(opType);
    }
}
