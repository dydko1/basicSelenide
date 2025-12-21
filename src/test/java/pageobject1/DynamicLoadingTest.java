package pageobject1;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicLoadingTest {

    @Test
    void example1_hiddenElement() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.openExample1();
        assertThat(dynamicLoadingPage.isFinishInDomNow()).isTrue();
        assertThat(dynamicLoadingPage.isFinishVisibleNow()).isFalse();
        dynamicLoadingPage.clickStartAndWaitForHelloWorld();
        assertThat(dynamicLoadingPage.isFinishVisibleNow()).isTrue();
    }
}
