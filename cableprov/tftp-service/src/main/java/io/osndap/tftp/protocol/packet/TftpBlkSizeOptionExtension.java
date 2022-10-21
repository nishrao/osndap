package io.osndap.tftp.protocol.packet;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TftpBlkSizeOptionExtension extends TftpOptionExtension{
    private int blkSize;
    public TftpBlkSizeOptionExtension(TftpOptionType optionType, int value) {
        setOpType(optionType);
        this.blkSize = value;
    }
}
