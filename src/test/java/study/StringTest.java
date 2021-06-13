package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String alphabet = "a,b,c";
        String[] split = alphabet.split(",");
        assertThat(split).contains("a","b","c");
        assertThat(split).containsExactly("a","b","c");
    }

    @Test
    void substring(){
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("charAt()했을 때 범위를 벗어났을 때")
    @Test
    void charAt(){
        String charTest = "abcdef";
        char selectOne = charTest.charAt(2); // 'c' 뽑기
        assertThat(selectOne).isEqualTo('c');
        assertThatThrownBy(() -> charTest.charAt(6)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 6");
    }
}
