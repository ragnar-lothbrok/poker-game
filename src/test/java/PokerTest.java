import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.game.exception.PokerException;
import com.game.service.PokerService;

public class PokerTest {

    PokerService pokerService;

    @Before
    public void init() {
        this.pokerService = new PokerService();
    }

    @Test
    public void test1() throws PokerException {
        Assert.assertEquals(this.pokerService.calculateRank(new String[] { "HT", "SJ", "DQ", "CK", "HA" }), "straight");
    }

    @Test
    public void test2() throws PokerException {
        Assert.assertEquals(this.pokerService.calculateRank(new String[] { "H2", "S3", "D4", "C5", "H6" }), "straight");
    }

    @Test
    public void test3() throws PokerException {
        Assert.assertEquals(this.pokerService.calculateRank(new String[] { "HA", "H2", "S3", "D4", "C5" }), "straight");

    }

    @Test
    public void test5() throws PokerException {
        Assert.assertEquals(this.pokerService.calculateRank(new String[] { "H2", "C2", "D2", "S2", "H3" }),
                "four-­‐of-­‐a-­‐kind");

    }

    @Test
    public void test6() throws PokerException {
        Assert.assertTrue("three-­‐of-­‐a-­‐kind".equals(this.pokerService.calculateRank(new String[] { "SA", "HA",
                "CA", "C2", "C5" })));

    }

    // @Test
    // public void test7() throws PokerException {
    // Assert.assertEquals(this.pokerService.calculateRank(new String[] { "SA",
    // "HA", "CA", "C5", "C5" }), "");
    //
    // }

    @Test
    public void test4() throws PokerException {
        Assert.assertEquals(this.pokerService.calculateRank(new String[] { "SA", "HA", "C6", "C2", "C5" }), "pair");

    }

    @Test
    public void test8() throws PokerException {
        Assert.assertEquals(this.pokerService.calculateRank(new String[] { "HA", "HK", "H2", "H4", "HT" }), "flush");

    }

    @Test
    public void test9() throws PokerException {
        Assert.assertEquals(this.pokerService.calculateRank(new String[] { "S2", "D5", "C7", "ST", "HA" }),
                "high-­‐card");

    }
}
