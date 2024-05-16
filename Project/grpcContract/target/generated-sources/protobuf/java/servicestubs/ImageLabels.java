// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ServiceContract.proto

package servicestubs;

/**
 * Protobuf type {@code grpcservice.ImageLabels}
 */
public final class ImageLabels extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpcservice.ImageLabels)
    ImageLabelsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ImageLabels.newBuilder() to construct.
  private ImageLabels(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ImageLabels() {
    labels_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ImageLabels();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return servicestubs.ServiceContract.internal_static_grpcservice_ImageLabels_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return servicestubs.ServiceContract.internal_static_grpcservice_ImageLabels_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            servicestubs.ImageLabels.class, servicestubs.ImageLabels.Builder.class);
  }

  public static final int LABELS_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList labels_;
  /**
   * <code>repeated string labels = 1;</code>
   * @return A list containing the labels.
   */
  public com.google.protobuf.ProtocolStringList
      getLabelsList() {
    return labels_;
  }
  /**
   * <code>repeated string labels = 1;</code>
   * @return The count of labels.
   */
  public int getLabelsCount() {
    return labels_.size();
  }
  /**
   * <code>repeated string labels = 1;</code>
   * @param index The index of the element to return.
   * @return The labels at the given index.
   */
  public java.lang.String getLabels(int index) {
    return labels_.get(index);
  }
  /**
   * <code>repeated string labels = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the labels at the given index.
   */
  public com.google.protobuf.ByteString
      getLabelsBytes(int index) {
    return labels_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < labels_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, labels_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < labels_.size(); i++) {
        dataSize += computeStringSizeNoTag(labels_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getLabelsList().size();
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof servicestubs.ImageLabels)) {
      return super.equals(obj);
    }
    servicestubs.ImageLabels other = (servicestubs.ImageLabels) obj;

    if (!getLabelsList()
        .equals(other.getLabelsList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getLabelsCount() > 0) {
      hash = (37 * hash) + LABELS_FIELD_NUMBER;
      hash = (53 * hash) + getLabelsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static servicestubs.ImageLabels parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static servicestubs.ImageLabels parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static servicestubs.ImageLabels parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static servicestubs.ImageLabels parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static servicestubs.ImageLabels parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static servicestubs.ImageLabels parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static servicestubs.ImageLabels parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static servicestubs.ImageLabels parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static servicestubs.ImageLabels parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static servicestubs.ImageLabels parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static servicestubs.ImageLabels parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static servicestubs.ImageLabels parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(servicestubs.ImageLabels prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpcservice.ImageLabels}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpcservice.ImageLabels)
      servicestubs.ImageLabelsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return servicestubs.ServiceContract.internal_static_grpcservice_ImageLabels_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return servicestubs.ServiceContract.internal_static_grpcservice_ImageLabels_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              servicestubs.ImageLabels.class, servicestubs.ImageLabels.Builder.class);
    }

    // Construct using servicestubs.ImageLabels.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      labels_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return servicestubs.ServiceContract.internal_static_grpcservice_ImageLabels_descriptor;
    }

    @java.lang.Override
    public servicestubs.ImageLabels getDefaultInstanceForType() {
      return servicestubs.ImageLabels.getDefaultInstance();
    }

    @java.lang.Override
    public servicestubs.ImageLabels build() {
      servicestubs.ImageLabels result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public servicestubs.ImageLabels buildPartial() {
      servicestubs.ImageLabels result = new servicestubs.ImageLabels(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        labels_ = labels_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.labels_ = labels_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof servicestubs.ImageLabels) {
        return mergeFrom((servicestubs.ImageLabels)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(servicestubs.ImageLabels other) {
      if (other == servicestubs.ImageLabels.getDefaultInstance()) return this;
      if (!other.labels_.isEmpty()) {
        if (labels_.isEmpty()) {
          labels_ = other.labels_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureLabelsIsMutable();
          labels_.addAll(other.labels_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();
              ensureLabelsIsMutable();
              labels_.add(s);
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList labels_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureLabelsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        labels_ = new com.google.protobuf.LazyStringArrayList(labels_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string labels = 1;</code>
     * @return A list containing the labels.
     */
    public com.google.protobuf.ProtocolStringList
        getLabelsList() {
      return labels_.getUnmodifiableView();
    }
    /**
     * <code>repeated string labels = 1;</code>
     * @return The count of labels.
     */
    public int getLabelsCount() {
      return labels_.size();
    }
    /**
     * <code>repeated string labels = 1;</code>
     * @param index The index of the element to return.
     * @return The labels at the given index.
     */
    public java.lang.String getLabels(int index) {
      return labels_.get(index);
    }
    /**
     * <code>repeated string labels = 1;</code>
     * @param index The index of the value to return.
     * @return The bytes of the labels at the given index.
     */
    public com.google.protobuf.ByteString
        getLabelsBytes(int index) {
      return labels_.getByteString(index);
    }
    /**
     * <code>repeated string labels = 1;</code>
     * @param index The index to set the value at.
     * @param value The labels to set.
     * @return This builder for chaining.
     */
    public Builder setLabels(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureLabelsIsMutable();
      labels_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string labels = 1;</code>
     * @param value The labels to add.
     * @return This builder for chaining.
     */
    public Builder addLabels(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureLabelsIsMutable();
      labels_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string labels = 1;</code>
     * @param values The labels to add.
     * @return This builder for chaining.
     */
    public Builder addAllLabels(
        java.lang.Iterable<java.lang.String> values) {
      ensureLabelsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, labels_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string labels = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearLabels() {
      labels_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string labels = 1;</code>
     * @param value The bytes of the labels to add.
     * @return This builder for chaining.
     */
    public Builder addLabelsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureLabelsIsMutable();
      labels_.add(value);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpcservice.ImageLabels)
  }

  // @@protoc_insertion_point(class_scope:grpcservice.ImageLabels)
  private static final servicestubs.ImageLabels DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new servicestubs.ImageLabels();
  }

  public static servicestubs.ImageLabels getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ImageLabels>
      PARSER = new com.google.protobuf.AbstractParser<ImageLabels>() {
    @java.lang.Override
    public ImageLabels parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ImageLabels> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ImageLabels> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public servicestubs.ImageLabels getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

