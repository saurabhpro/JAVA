package set;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThatNoException;

class LinkedHashSetClassTest {

    @Test
    void calling_reversed_returns_mutable_list_on_arraylist() {
        // given
        var list = new LinkedHashSet<Integer>();
        list.add(1);
        list.add(2);

        var reversed = list.reversed();

        // when/ then
        assertThatNoException().isThrownBy(() -> reversed.add(4));
    }

//    @Test
//    void calling_reversed_returns_mutable_list_on_list() {
//        // given
//        var list = Set.of(1, 2);
//
//        var reversed = list.reversed();
//
//        // when/ then
//        assertThatThrownBy(() -> reversed.add(4))
//            .isInstanceOf(UnsupportedOperationException.class);
//    }
}