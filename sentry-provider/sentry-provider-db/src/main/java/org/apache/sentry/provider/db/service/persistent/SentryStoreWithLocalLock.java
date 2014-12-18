/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.sentry.provider.db.service.persistent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * An implementation of {@link LockingSentryStore} that implements the
 * Locking strategy using the standard
 * {@link java.util.concurrent.locks.ReentrantReadWriteLock}
 *
 */
public class SentryStoreWithLocalLock extends
    LockingSentryStore<SentryStoreWithLocalLock.ThreadSafeContext> {

  public static class ThreadSafeContext implements
      LockingSentryStore.LockContext {
    final Lock lock;

    public ThreadSafeContext(Lock lock) {
      this.lock = lock;
    }

    @Override
    public void unlock() {
      lock.unlock();
    }
  }

  private final ReadWriteLock rwLock;

  public SentryStoreWithLocalLock(SentryStore sentryStore) {
    super(sentryStore);
    this.rwLock = new ReentrantReadWriteLock();
  }

  @Override
  protected ThreadSafeContext writeLock() {
    return new ThreadSafeContext(rwLock.writeLock());
  }

  @Override
  protected ThreadSafeContext readLock() {
    return new ThreadSafeContext(rwLock.readLock());
  }

}
