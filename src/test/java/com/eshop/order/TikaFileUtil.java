package com.eshop.order;

import lombok.extern.slf4j.Slf4j;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.http.HttpHeaders;
import org.xml.sax.ContentHandler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Slf4j
public class TikaFileUtil {

    public static String getFileExtension(byte[] fileContent) {
        InputStream is = new ByteArrayInputStream(fileContent);
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        MediaType mediaType;
        try {
            ContentHandler handler = new BodyContentHandler();
            parser.parse(is, handler, metadata);
            mediaType = MediaType.parse(metadata.get(HttpHeaders.CONTENT_TYPE));
            TikaConfig tikaConfig = TikaConfig.getDefaultConfig();
            MimeTypes allTypes = tikaConfig.getMimeRepository();
            return allTypes.forName(mediaType.toString()).getExtension();
        } catch (Exception e) {
            log.error("getFileType error", e);
            return null;
        }
    }

    public static String getMimeType(byte[] fileContent) {
        InputStream is = new ByteArrayInputStream(fileContent);
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        MediaType mediaType;
        try {
            ContentHandler handler = new BodyContentHandler();
            parser.parse(is, handler, metadata);
            mediaType = MediaType.parse(metadata.get(HttpHeaders.CONTENT_TYPE));
            return mediaType.toString();
        } catch (Exception e) {
            log.error("getMimeType error", e);
            return null;
        }
    }
}
