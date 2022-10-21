package io.osndap.tftp.protocol.packet;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class TftpOptionExtension {
       private TftpOptionType opType;
}
