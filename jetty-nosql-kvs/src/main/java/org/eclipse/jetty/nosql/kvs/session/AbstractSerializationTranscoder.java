/*
 * FILENAME
 *     AbstractSerializationTranscoder.java
 *
 * FILE LOCATION
 *     $Source$
 *
 * VERSION
 *     $Id$
 *         @version       $Revision$
 *         Check-Out Tag: $Name$
 *         Locked By:     $Lockers$
 *
 * FORMATTING NOTES
 *     * Lines should be limited to 78 characters.
 *     * Files should contain no tabs.
 *     * Indent code using four-character increments.
 *
 * COPYRIGHT
 *     Copyright (C) 2007 Genix Ventures Pty. Ltd. All rights reserved.
 *     This software is the confidential and proprietary information of
 *     Genix Ventures ("Confidential Information"). You shall not
 *     disclose such Confidential Information and shall use it only in
 *     accordance with the terms of the license agreement you entered into
 *     with Genix Ventures.
 */

package org.eclipse.jetty.nosql.kvs.session;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * Default abstract implementation of {@link ISerializationTranscoder}.
 * </p>
 * 
 * @since 0.3.2
 * @author ttran
 **/
public abstract class AbstractSerializationTranscoder implements ISerializationTranscoder
{
    private boolean compressionEnabled;

    public final boolean isCompressionEnabled()
    {
        return compressionEnabled;
    }

    public final void setCompressionEnabled(final boolean enabled)
    {
        compressionEnabled = enabled;
    }
}
