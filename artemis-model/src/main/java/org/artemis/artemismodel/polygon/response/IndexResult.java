package org.artemis.artemismodel.polygon.response;

import lombok.Data;

@Data
public class IndexResult {
    /**
     * Included only if expandUnderlying in the request
     * was true.
     * */
    private Underlying underlying;
    /***
     * The index values.
     */
    private IndexValues values;
}
