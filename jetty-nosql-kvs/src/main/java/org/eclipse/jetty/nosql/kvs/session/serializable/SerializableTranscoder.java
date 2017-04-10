package org.eclipse.jetty.nosql.kvs.session.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.eclipse.jetty.nosql.kvs.session.AbstractSerializationTranscoder;
import org.eclipse.jetty.nosql.kvs.session.TranscoderException;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class SerializableTranscoder extends AbstractSerializationTranscoder {
    private final static Logger log = Log.getLogger(SerializableTranscoder.class);

    public byte[] encode(final Object obj) throws TranscoderException
    {
        if (obj == null)
        {
            return null;
        }
        byte[] raw = null;
        ByteArrayOutputStream baos = null;
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try
        {
            baos = new ByteArrayOutputStream();
            if (isCompressionEnabled())
                os = new GZIPOutputStream(baos);
            else
                os = baos;
            oos = new ObjectOutputStream(os);
            oos.writeObject(obj);

            closeQuietly(oos);
            if (isCompressionEnabled())
                closeQuietly(os);
            closeQuietly(baos);

            raw = baos.toByteArray();
        }
        catch (Exception error)
        {
            throw (new TranscoderException(error));
        }
        finally
        {
            closeQuietly(oos);
            if (isCompressionEnabled())
                closeQuietly(os);
            closeQuietly(baos);
        }
        return raw;
    }

    @SuppressWarnings("unchecked")
    public <T> T decode(final byte[] raw, final Class<T> klass) throws TranscoderException
    {
        if (raw == null)
        {
            return null;
        }
        Object obj = null;
        ByteArrayInputStream bais = null;
        InputStream is = null;
        ObjectInputStream ois = null;
        try
        {
            bais = new ByteArrayInputStream(raw);
            if (isCompressionEnabled())
                is = new GZIPInputStream(bais);
            else
                is = bais;
            ois = new ClassLoadingObjectInputStream(is, Thread.currentThread().getContextClassLoader());
            obj = ois.readObject();
        }
        catch (Exception error)
        {
            throw (new TranscoderException(error));
        }
        finally
        {
            closeQuietly(ois);
            if (isCompressionEnabled())
                closeQuietly(is);
            closeQuietly(bais);
        }
        return (T) obj;
    }

    private static void closeQuietly(final Closeable closeable)
    {
        if (closeable == null)
            return;
        try
        {
            closeable.close();
        }
        catch (IOException e)
        {
            log.warn("IOException thrown while closing Closeable.", e); //$NON-NLS-1$
        }
    }
}
