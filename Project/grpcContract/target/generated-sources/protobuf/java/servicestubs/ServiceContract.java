// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ServiceContract.proto

package servicestubs;

public final class ServiceContract {
  private ServiceContract() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcservice_TextMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcservice_TextMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcservice_InputFile_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcservice_InputFile_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcservice_ImageLabels_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcservice_ImageLabels_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcservice_ImageNames_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcservice_ImageNames_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcservice_DatesAndLabel_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcservice_DatesAndLabel_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcservice_Image_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcservice_Image_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025ServiceContract.proto\022\013grpcservice\"\032\n\013" +
      "TextMessage\022\013\n\003txt\030\001 \001(\t\"A\n\tInputFile\022\023\n" +
      "\013contentType\030\001 \001(\t\022\r\n\005image\030\002 \001(\014\022\020\n\010fil" +
      "eName\030\003 \001(\t\"\035\n\013ImageLabels\022\016\n\006labels\030\001 \003" +
      "(\t\"\033\n\nImageNames\022\r\n\005names\030\001 \003(\t\"C\n\rDates" +
      "AndLabel\022\020\n\010initDate\030\001 \001(\t\022\021\n\tfinalDate\030" +
      "\002 \001(\t\022\r\n\005label\030\003 \001(\t\"\026\n\005Image\022\r\n\005image\030\001" +
      " \001(\0142\237\002\n\007Service\022>\n\nsubmitFile\022\026.grpcser" +
      "vice.InputFile\032\030.grpcservice.TextMessage" +
      "\022D\n\016getImageLabels\022\030.grpcservice.TextMes" +
      "sage\032\030.grpcservice.ImageLabels\022O\n\030getNam" +
      "esFromDateAndLabel\022\032.grpcservice.DatesAn" +
      "dLabel\032\027.grpcservice.ImageNames\022=\n\rdownl" +
      "oadImage\022\030.grpcservice.TextMessage\032\022.grp" +
      "cservice.ImageB\020\n\014servicestubsP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_grpcservice_TextMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpcservice_TextMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcservice_TextMessage_descriptor,
        new java.lang.String[] { "Txt", });
    internal_static_grpcservice_InputFile_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpcservice_InputFile_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcservice_InputFile_descriptor,
        new java.lang.String[] { "ContentType", "Image", "FileName", });
    internal_static_grpcservice_ImageLabels_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_grpcservice_ImageLabels_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcservice_ImageLabels_descriptor,
        new java.lang.String[] { "Labels", });
    internal_static_grpcservice_ImageNames_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_grpcservice_ImageNames_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcservice_ImageNames_descriptor,
        new java.lang.String[] { "Names", });
    internal_static_grpcservice_DatesAndLabel_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_grpcservice_DatesAndLabel_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcservice_DatesAndLabel_descriptor,
        new java.lang.String[] { "InitDate", "FinalDate", "Label", });
    internal_static_grpcservice_Image_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_grpcservice_Image_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcservice_Image_descriptor,
        new java.lang.String[] { "Image", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
