// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ServiceContract.proto

package servicestubs;

public interface InputFileOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpcservice.InputFile)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string contentType = 1;</code>
   * @return The contentType.
   */
  java.lang.String getContentType();
  /**
   * <code>string contentType = 1;</code>
   * @return The bytes for contentType.
   */
  com.google.protobuf.ByteString
      getContentTypeBytes();

  /**
   * <code>bytes file = 2;</code>
   * @return The file.
   */
  com.google.protobuf.ByteString getFile();

  /**
   * <code>string fileName = 3;</code>
   * @return The fileName.
   */
  java.lang.String getFileName();
  /**
   * <code>string fileName = 3;</code>
   * @return The bytes for fileName.
   */
  com.google.protobuf.ByteString
      getFileNameBytes();
}
