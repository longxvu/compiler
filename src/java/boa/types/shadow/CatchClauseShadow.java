// NOTE: This file was automatically generated - DO NOT EDIT
/*
 * Copyright 2017, Robert Dyer, Kaushik Nimmala
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
package boa.types.shadow;

import java.util.ArrayList;
import java.util.List;

import boa.compiler.ast.expressions.Expression;
import boa.compiler.ast.Factor;
import boa.compiler.ast.Identifier;
import boa.compiler.ast.Node;
import boa.compiler.ast.statements.Block;
import boa.compiler.ast.statements.IfStatement;
import boa.compiler.SymbolTable;
import boa.compiler.transforms.ASTFactory;

/**
 * A shadow type for Statement.
 *
 * @author rdyer
 * @author kaushin
 */
public class CatchClauseShadow extends boa.types.BoaShadowType  {
    /**
     * Construct a {@link CatchClauseShadow}.
     */
    public CatchClauseShadow() {
        super(new boa.types.proto.StatementProtoTuple());

        addShadow("exception", new boa.types.proto.VariableProtoTuple());
        addShadow("body", new boa.types.BoaProtoList(new boa.types.proto.StatementProtoTuple()));
    }

    /** {@inheritDoc} */
    @Override
    public boolean assigns(final boa.types.BoaType that) {
        if (that instanceof boa.types.BoaShadowType)
            return shadowedType.assigns(that);

        if (!super.assigns(that))
            return false;

        return this.getClass() == that.getClass();
    }

    /** {@inheritDoc} */
    @Override
    public Node lookupCodegen(final String name, final Factor fact, final SymbolTable env) {
        if ("exception".equals(name)) return ASTFactory.createSelector("variable_1", new boa.types.proto.VariableProtoTuple(), env);
        if ("body".equals(name)) return ASTFactory.createSelector("statements_1", new boa.types.BoaProtoList(new boa.types.BoaProtoList(new boa.types.proto.StatementProtoTuple())), env);

        throw new RuntimeException("invalid shadow field '" + name + "' in shadow type CatchClauseShadow");
    }

    /** {@inheritDoc} */
    @Override
    public Expression getKindExpression(final SymbolTable env) {
        return getKindExpression("StatementKind", "CATCH", new boa.types.proto.enums.StatementKindProtoMap(), env);
    }

    /** {@inheritDoc} */
    @Override
    public IfStatement getManytoOne(final SymbolTable env, final Block b) {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public List<Expression> getOneToMany(final SymbolTable env) {
        final List<Expression> l = new ArrayList<Expression>();


        return l;
    }

    /**
     * Converts a shadow type message into a concrete type message.
     *
     * @param m the shadow type message
     * @return the concrete message
     */
    public boa.types.Ast.Statement flattenMessage(final boa.types.Ast.Statement.CatchClause m) {
        final boa.types.Ast.Statement.Builder b = boa.types.Ast.Statement.newBuilder();
        b.setKind(boa.types.Ast.Statement.StatementKind.CATCH);
        b.setVariable1(m.getException());
        for (int i = 0; i < m.getBodyCount(); i++) b.addStatements1(m.getBody(i));
        return b.build();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "CatchClause";
    }
}