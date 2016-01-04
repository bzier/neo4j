/**
 * Copyright (c) 2002-2016 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.impl.core;

import org.neo4j.kernel.api.properties.DefinedProperty;

public interface PropertyChainVerifier
{
    /**
     * Verify that the array of DefinedProperties, that is sorted by their
     * propertyKeyIds, is consistent and contains no duplicates.
     * @param properties The properties to verify.
     */
    public void verifySortedPropertyChain( DefinedProperty[] properties, Primitive entity );

    public void addObserver( Observer o );

    public interface Observer
    {
        void inconsistencyFound( Primitive owningPrimitive );
    }
}