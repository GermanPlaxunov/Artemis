package org.artemis.artemismodel.polygon.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class IndexResult {
    /**
     * Included only if expandUnderlying in the request
     * was true.
     */
    @JsonProperty("underlying")
    private Underlying underlying;
    /***
     * The index values.
     */
    @JsonProperty("values")
    private List<IndexValues> values;
}
