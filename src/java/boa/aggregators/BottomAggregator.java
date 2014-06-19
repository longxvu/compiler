/*
 * Copyright 2014, Anthony Urso, Hridesh Rajan, Robert Dyer, 
 *                 and Iowa State University of Science and Technology
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
package boa.aggregators;

/**
 * A Boa aggregator to estimate the bottom <i>n</i> values in a dataset by
 * cardinality.
 * 
 * @author anthonyu
 * @author rdyer
 */
@AggregatorSpec(name = "bottom", formalParameters = { "int" }, weightType = "int", canCombine = true)
public class BottomAggregator extends BottomOrTopAggregator {
	/**
	 * Construct a {@link BottomAggregator}.
	 * 
	 * @param n A long representing the number of values to return
	 */
	public BottomAggregator(final long n) {
		super(n);

		DefaultValue = Long.MAX_VALUE;
	}

	/** {@inheritDoc} */
	@Override
	protected boolean shouldInsert(final long a, final long b) {
		return a < b;
	}
}