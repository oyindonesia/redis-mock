package ai.grakn.redismock.commands;

import ai.grakn.redismock.RedisBase;
import ai.grakn.redismock.Slice;

import java.util.List;

import static ai.grakn.redismock.Utils.convertToLong;

class RO_decrby extends RO_incrOrDecrBy {
    RO_decrby(RedisBase base, List<Slice> params) {
        super(base, params, 2);
    }

    RO_decrby(RedisBase base, List<Slice> params, Integer expectedParams) {
        super(base, params, expectedParams);
    }

    long incrementOrDecrementValue(List<Slice> params){
        return convertToLong(String.valueOf(params.get(1))) * -1;
    }
}
