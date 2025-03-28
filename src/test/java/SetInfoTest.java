import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SetInfoTest {
    
    @Test
    public void testSetInfoCreation() {
        SetInfo setInfo = new SetInfo(100, 10);
        
        assertEquals(100, setInfo.getWeight());
        assertEquals(10, setInfo.getReps());
    }
    
    @Test
    public void testSetInfoUpdate() {
        SetInfo setInfo = new SetInfo(100, 10);
        
        // Update the weight and reps
        setInfo.setWeight(110);
        setInfo.setReps(8);
        
        // Verify the updates
        assertEquals(110, setInfo.getWeight());
        assertEquals(8, setInfo.getReps());
    }
}
