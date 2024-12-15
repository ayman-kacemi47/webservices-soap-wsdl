package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;


// c'est une classe POJO

@WebService(serviceName = "BanqueWS")
public class BanqueServices {

    @WebMethod(operationName = "conversionEuroToMAD")
    public double conversion(@WebParam(name= "montant") double mt){
        return mt*11;
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "code") int code){
        return new Compte(code, 3112 + Math.random()*10000, new Date());
    }

    @WebMethod
    public List<Compte> listComptes(){
        return List.of(
                new Compte(1,3112 + Math.random()*10000, new Date() ),
                new Compte(2,3112 + Math.random()*10000, new Date() ),

                new Compte(3,3112 + Math.random()*10000, new Date() ),

                new Compte(4,3112 + Math.random()*10000, new Date() )

        );
    }
}
