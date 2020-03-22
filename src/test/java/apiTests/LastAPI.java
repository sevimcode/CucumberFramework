package apiTests;

import org.junit.Assert;
import org.junit.Test;
import utilities.APIUtil;

public class LastAPI{

    @Test
    public void deleteMessageTesting() { //deleting teacher in the app

        String resourceForDelete = "/teacher/delete/2708";
        APIUtil.hitDELETE (resourceForDelete);

        String resourceForGet = "/teacher/2708";
        APIUtil.hitGET (resourceForGet);

        String message = APIUtil.getResponseBody ().getMessage ();

        System.out.println (message);
        Assert.assertEquals ("Teacher with id = 2708 NOT FOUND!",message);
    }

    @Test
    public void deleteMessageTestingNegative() { //deleting teacher is not in the app

        String resourceForDelete = "/teacher/delete/2708798";
        APIUtil.hitDELETE (resourceForDelete);

        String resourceForGet = "/teacher/2708798";
        APIUtil.hitGET (resourceForGet);

        String message = APIUtil.getResponseBody ().getMessage ();

        System.out.println (message);
        Assert.assertEquals ("Teacher with id = 2708798 NOT FOUND!",message);
    }

}