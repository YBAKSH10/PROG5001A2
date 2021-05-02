/**
 * The given snake class is an abstract class that defines its methods.
 *
 * @author Yamini
 * @version 2.0 (23706019)
 */
abstract class Yb_Snake
{
    /** Method Move
     * This method will help the snake to move in various directions using the arrow keys.
     * 
     */
    public abstract void Move();
    
    /** Method EatPrey
     * This method will allow snake to eat the prey
     * 
     */
    public abstract void EatPrey();
    
    /** Method Grow
     * This method will allow snake to eat the prey and grow.
     * 
     */
    public abstract void Grow();
}

