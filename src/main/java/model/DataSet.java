package model;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class DataSet {
    private String name;
    private String status;
    private String type;
    private String size;
    private String upload;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSet that = (DataSet) o;
        return Objects.equals(name, that.name) && Objects.equals(status, that.status) && Objects.equals(type, that.type) && Objects.equals(size, that.size) && Objects.equals(upload, that.upload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, type, size, upload);
    }
}
