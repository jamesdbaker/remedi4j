/*
National Crime Agency (c) Crown Copyright 2018

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package uk.gov.nca.remedi4j.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class PostProcessorRequestTest {
  @Test
  public void testGetterAndSetters() {
    new BeanTester().testBean(PostProcessorRequest.class);
  }

  @Test
  public void testEqualsAndHashCode(){
    EqualsVerifier.forClass(PostProcessorRequest.class)
        .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS, Warning.ALL_FIELDS_SHOULD_BE_USED)
        .verify();
  }

  @Test
  public void testGenerateMD5(){
    PostProcessorRequest ppr = new PostProcessorRequest();
    ppr.setText("Hello, world!");

    assertEquals("6cd3556deb0da54bca060b4c39479839", ppr.generateJobToken());
  }
}
