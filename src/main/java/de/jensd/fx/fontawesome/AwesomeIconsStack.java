/**
 * Copyright (c) 2014 Jens Deters http://www.jensd.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package de.jensd.fx.fontawesome;

import javafx.scene.layout.StackPane;

/**
 *
 * @author Jens Deters
 */
public class AwesomeIconsStack extends StackPane {

    public static AwesomeIconsStack create() {
        return new AwesomeIconsStack();
    }


    public AwesomeIconsStack add(Icon icon) {
        getChildren().add(icon);
        return this;
    }

    public AwesomeIconsStack remove(Icon icon) {
        getChildren().remove(icon);
        return this;
    }

}
