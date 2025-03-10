/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.maven.execution;

import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.project.MavenProject;

/**
 * Holds data relevant for an execution event.
 *
 */
public interface ExecutionEvent {

    /**
     * The possible types of execution events.
     *
     * Note: do not modify this enum, or, make sure that this enum and
     * {@link org.apache.maven.api.EventType} have same elements in same order.
     */
    enum Type {
        ProjectDiscoveryStarted,
        SessionStarted,
        SessionEnded,
        ProjectSkipped,
        ProjectStarted,
        ProjectSucceeded,
        ProjectFailed,
        MojoSkipped,
        MojoStarted,
        MojoSucceeded,
        MojoFailed,
        ForkStarted,
        ForkSucceeded,
        ForkFailed,
        ForkedProjectStarted,
        ForkedProjectSucceeded,
        ForkedProjectFailed,
    }

    /**
     * Gets the type of the event.
     *
     * @return The type of the event, never {@code null}.
     */
    Type getType();

    /**
     * Gets the session from which this event originates.
     *
     * @return The current session, never {@code null}.
     */
    MavenSession getSession();

    /**
     * Gets the current project (if any).
     *
     * @return The current project or {@code null} if not applicable.
     */
    MavenProject getProject();

    /**
     * Gets the current mojo execution (if any).
     *
     * @return The current mojo execution or {@code null} if not applicable.
     */
    MojoExecution getMojoExecution();

    /**
     * Gets the exception that caused the event (if any).
     *
     * @return The exception or {@code null} if none.
     */
    Exception getException();
}
