// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ServiceContract.proto

package servicestubs;

public interface ImageLabelsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpcservice.ImageLabels)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string labels = 1;</code>
   * @return A list containing the labels.
   */
  java.util.List<java.lang.String>
      getLabelsList();
  /**
   * <code>repeated string labels = 1;</code>
   * @return The count of labels.
   */
  int getLabelsCount();
  /**
   * <code>repeated string labels = 1;</code>
   * @param index The index of the element to return.
   * @return The labels at the given index.
   */
  java.lang.String getLabels(int index);
  /**
   * <code>repeated string labels = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the labels at the given index.
   */
  com.google.protobuf.ByteString
      getLabelsBytes(int index);
}