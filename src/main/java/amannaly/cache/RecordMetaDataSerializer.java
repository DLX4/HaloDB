package amannaly.cache;

import amannaly.RecordMetaDataForCache;
import amannaly.ohc.CacheSerializer;

import java.nio.ByteBuffer;

/**
 * @author Arjun Mannaly
 */
public class RecordMetaDataSerializer implements CacheSerializer<RecordMetaDataForCache> {

    public void serialize(RecordMetaDataForCache recordMetaData, ByteBuffer byteBuffer) {
        byteBuffer.putInt(recordMetaData.getFileId());
        byteBuffer.putLong(recordMetaData.getOffset());
        byteBuffer.putInt(recordMetaData.getRecordSize());
        byteBuffer.flip();
    }

    public RecordMetaDataForCache deserialize(ByteBuffer byteBuffer) {
        int fileId = byteBuffer.getInt();
        long offset = byteBuffer.getLong();
        int size = byteBuffer.getInt();

        return new RecordMetaDataForCache(fileId, offset, size);
    }

    public int serializedSize(RecordMetaDataForCache recordMetaData) {
        return SERIALIZED_SIZE;
    }

    static final int SERIALIZED_SIZE = 4 + 8 + 4;
}
