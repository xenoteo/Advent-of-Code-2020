package xenoteo.com.github.day25.part1;

/**
 * The handshake used by the card and the door involves an operation that transforms a subject number. To transform a
 * subject number, start with the value 1. Then, a number of times called the loop size, perform the following steps:
 * <ul>
 *     <li>Set the value to itself multiplied by the subject number.</li>
 *     <li>Set the value to the remainder after dividing the value by 20201227.</li>
 * </ul>
 *
 * The card always uses a specific, secret loop size when it transforms a subject number. The door always uses a
 * different, secret loop size.
 *
 * The cryptographic handshake works like this:
 * <ul>
 *     <li>The card transforms the subject number of 7 according to the card's secret loop size.</li>
 *     <li>
 *         The card transforms the subject number of 7 according to the card's secret loop size.
 *         The result is called the card's public key.
 *     </li>
 *     <li>
 *         The door transforms the subject number of 7 according to the door's secret loop size.
 *         The result is called the door's public key.
 *     </li>
 *     <li>
 *         The card and door use the wireless RFID signal to transmit the two public keys to the other device. Now, the
 *         card has the door's public key, and the door has the card's public key. Because you can eavesdrop on the
 *         signal, you have both public keys, but neither device's loop size.
 *     </li>
 *     <li>
 *         The card transforms the subject number of the door's public key according to the card's loop size.
 *         The result is the encryption key.
 *     </li>
 *     <li>
 *         The door transforms the subject number of the card's public key according to the door's loop size.
 *         The result is the same encryption key as the card calculated.
 *     </li>
 * </ul>
 *
 * If you can use the two public keys to determine each device's loop size, you will have enough information to calculate
 * the secret encryption key that the card and door use to communicate; this would let you send the unlock command
 * directly to the door!
 *
 * Class finding what encryption key the handshake is trying to establish.
 */
public class Solution {

    /**
     * Having the card's and the door's encryption keys, finds the encryption key.
     *
     * @param cardsPublicKey  the card's public key
     * @param doorsPublicKey  the door's public key
     * @return the encryption key
     */
    public long encryptionKey(int cardsPublicKey, int doorsPublicKey){
        int doorsLoopSize = doorsLoopSize(doorsPublicKey);
        long value = 1;
        for (int i = 0; i < doorsLoopSize; i++){
            value *= cardsPublicKey;
            value %= 20201227;
        }
        return value;
    }

    /**
     * Finds the door's secret loop size.
     *
     * @param doorsPublicKey  the door's public key
     * @return the door's secret loop size
     */
    private int doorsLoopSize(int doorsPublicKey){
        int subjectNumber = 7;
        int value = 1;
        int loopSize = 0;
        while (value != doorsPublicKey){
            loopSize++;
            value *= subjectNumber;
            value %= 20201227;
        }
        return loopSize;
    }
}
