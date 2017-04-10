package org.eclipse.jetty.nosql.kvs.session;

public interface ISerializationTranscoder {
//	public byte[] encode(boolean b) throws TranscoderException;
//
//	public byte[] encode(char c) throws TranscoderException;
//
//	public byte[] encode(byte b) throws TranscoderException;
//
//	public byte[] encode(short s) throws TranscoderException;
//
//	public byte[] encode(int i) throws TranscoderException;
//
//	public byte[] encode(long l) throws TranscoderException;
//
//	public byte[] encode(float f) throws TranscoderException;
//
//	public byte[] encode(double d) throws TranscoderException;

    /**
     * <p>
     * Determine if the transcoder is set to compress/uncompress data during encode/decode process.
     * </p>
     * 
     * @since 0.3.2
     * @return true if data will be transferred in compressed state, false otherwise
     **/
    boolean isCompressionEnabled();

    /**
     * <p>
     * Specify if the transcoder should compress/uncompress data during encode/decode process.
     * </p>
     * 
     * @since 0.3.2
     **/
    void setCompressionEnabled(boolean enabled);

	/**
	 * serialize an object to byte array
	 * @param obj to serialize
	 * @return serialized data
	 * @throws TranscoderException encode error
	 */
	public byte[] encode(Object obj) throws TranscoderException;

	/**
	 * deserialize object(s) from byte array
	 * @param raw data
	 * @param klass of serialized data
	 * @return deserialized object(s)
	 * @throws TranscoderException decode error
	 */
	public <T> T decode(byte[] raw, Class<T> klass) throws TranscoderException;
}
