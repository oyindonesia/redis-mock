package ai.grakn.redismock.commands;

import ai.grakn.redismock.RedisBase;
import ai.grakn.redismock.Response;
import ai.grakn.redismock.Slice;

import java.util.List;
import java.util.Set;

import static ai.grakn.redismock.Utils.deserializeObject;

class RO_sismember extends AbstractRedisOperation {
    RO_sismember(RedisBase base, List<Slice> params) {
        super(base, params, 2, null, null);
    }

    Slice response() {
        Slice key = params().get(0);
        Slice data = base().rawGet(key);
        Set<Slice> set;
        if (data != null) {
            set = deserializeObject(data);
        } else {
            return Response.integer(0);
        }
        if (set.contains(params().get(1))) {
            return Response.integer(1);
        }
        return Response.integer(0);
    }
}