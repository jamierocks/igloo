/*
 * This file is part of igloo, licensed under the MIT License.
 *
 * Copyright (c) 2018 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.igloo.v3;

import net.kyori.igloo.http.Request;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Optional;

/* package */ final class CreatedIssue extends AbstractIssue {
  private final String html_url;
  private final User user;
  private final String title;
  private final String body;
  private final State state;

  /* package */ CreatedIssue(final Request request, final Partial.Issue partial) {
    super(request, partial.number);
    this.html_url = partial.html_url;
    this.user = new UserImpl(partial.user.login);
    this.title = partial.title;
    this.body = partial.body;
    this.state = partial.state;
  }

  @Override
  public @NonNull String html_url() {
    return this.html_url;
  }

  @Override
  public @NonNull User user() {
    return this.user;
  }

  @Override
  public @NonNull String title() {
    return this.title;
  }

  @Override
  public @NonNull String body() {
    return this.body;
  }

  @Override
  public Issue.@NonNull State state() {
    return this.state;
  }

  @Override
  public @NonNull Optional<PullRequest> pullRequest() {
    return Optional.empty();
  }
}
