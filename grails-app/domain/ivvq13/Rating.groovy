package ivvq13

/**
 * Values go from 1 to 5 (stars if you want)
 * 0 means no rating given
 * @author Vincent
 *
 */
class Rating {

	short value;
	User author;
	
    static constraints = {
		value (range: 0..5)
    }

}
