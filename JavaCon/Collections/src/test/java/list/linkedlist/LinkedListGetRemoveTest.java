package list.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinkedListGetRemoveTest {

    @Test
    void calling_reversed_returns_mutable_list_on_arraylist() {
        // given
        var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        var reversed = list.reversed();

        // when/ then
        assertThatNoException().isThrownBy(() -> reversed.add(4));
    }

    @Test
    void calling_reversed_returns_mutable_list_on_list() {
        // given
        var list = List.of(1, 2);

        var reversed = list.reversed();

        // when/ then
        assertThatThrownBy(() -> reversed.add(4))
            .isInstanceOf(UnsupportedOperationException.class);
    }
}
