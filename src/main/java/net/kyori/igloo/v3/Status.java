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

import com.google.gson.annotations.SerializedName;
import net.kyori.cereal.Document;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface Status {
  /**
   * Gets the state.
   *
   * @return the state
   */
  @NonNull State state();

  /**
   * Gets the target url.
   *
   * @return the target url.
   */
  String target_url();

  /**
   * Gets the description.
   *
   * @return the description
   */
  String description();

  /**
   * Gets the context.
   *
   * @return the context
   */
  String context();

  // Inheritance hack
  interface AbstractCreate extends Document, StatusPartial {
  }

  /**
   * A document that can be submitted during status creation.
   */
  interface Create extends AbstractCreate, StatusPartial.StatePartial {
    /**
     * A document containing all information that may be submitted during creation.
     */
    interface Full extends Create, TargetUrlPartial, DescriptionPartial, ContextPartial {
    }
  }

  /**
   * The state of a status.
   */
  enum State {
    @SerializedName("error")
    ERROR,
    @SerializedName("failure")
    FAILURE,
    @SerializedName("pending")
    PENDING,
    @SerializedName("success")
    SUCCESS;
  }
}
