// NOTE: This file was automatically generated - DO NOT EDIT
/*
 * Copyright 2017, Hridesh Rajan, Robert Dyer
 *                 Iowa State University of Science and Technology
 *                 and Bowling Green State University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package boa.types.proto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A {@link IssueChangeProtoTuple}.
 *
 * @author rdyer
 */
public class IssueChangeProtoTuple extends boa.types.BoaProtoTuple {
    private final static List<boa.types.BoaType> members = new ArrayList<boa.types.BoaType>();
    private final static Map<String, Integer> names = new HashMap<String, Integer>();

    static {
        int count = 0;

        names.put("id", count++);
        members.add(new boa.types.BoaString());

        names.put("what", count++);
        members.add(new boa.types.BoaString());

        names.put("date", count++);
        members.add(new boa.types.BoaInt());

        names.put("author", count++);
        members.add(new boa.types.proto.PersonProtoTuple());

        names.put("old_value", count++);
        members.add(new boa.types.BoaString());

        names.put("new_value", count++);
        members.add(new boa.types.BoaString());

        names.put("description", count++);
        members.add(new boa.types.BoaString());
    }

    /**
     * Construct a {@link IssueChangeProtoTuple}.
     */
    public IssueChangeProtoTuple() {
        super(members, names);
    }

    /** @{inheritDoc} */
    @Override
    public String toJavaType() {
        return "boa.types.Issues.IssueChange";
    }
}