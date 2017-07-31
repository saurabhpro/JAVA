/**
 * To set any bit we use bitwise OR | operator. As we already know bitwise OR | operator evaluates each bit
 * of the result to 1 if any of the operand’s corresponding bit is set (1). In-order to set kth bit of a number
 * we need to shift 1 k times to its left and then perform bitwise OR operation with the number and result
 * of left shift performed just before.
 * <p>
 * In general, (1 << k) | n.
 * Created by saurabhkumar on 31/07/17.
 */
public class G_SetKthBit {
	static int setKthBit(int number, int kthPosition) {

		int temp = 1 << kthPosition;

		return number | temp;
	}
}
