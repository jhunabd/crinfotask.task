package crinfotask.task.controllers;


import crinfotask.task.domains.Credit;
import crinfotask.task.domains.CreditHistory;
import crinfotask.task.domains.Person;
import crinfotask.task.jwt.JwtUtil;
import crinfotask.task.services.interfaces.CreditService;
import crinfotask.task.services.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/credit/", "credit/"})
public class CreditController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CreditService creditService;

    @Autowired
    private PersonService personService;


    // add credit
    @PostMapping("/add")
    public ResponseEntity<?> addCredit(@RequestBody Credit credit) {
        return ResponseEntity.ok(creditService.addCredit(credit));
    }


    //get credit history with credit
    @GetMapping("/history")
    public ResponseEntity<List<CreditHistory>> getCreditHistory(
            HttpServletRequest request
    ) {
        Person person = null;
        String token = request.getHeader("Authorization").substring(7);
        Optional<Person> optionalPerson = personService.getPersonByEmail(jwtUtil.extractUsername(token));
        if (optionalPerson.isPresent()) {
            person = optionalPerson.get();
        }
        List<CreditHistory> creditHistories = creditService.getCreditHistoriesByPersonId(person.getId());
        return ResponseEntity.ok(creditHistories);
    }

    @PutMapping("/history/{id}")
    public ResponseEntity<CreditHistory> updateCreditHistoryById(
            @RequestBody CreditHistory creditHistory
    ){
        System.out.println(creditHistory);
        Optional<CreditHistory> optionalCreditHistory = creditService.getCreditHistoryById(creditHistory.getId());
        if(optionalCreditHistory.isPresent()){
            CreditHistory creditHistoryAfterUpdate = creditService.updateCreditHistoryById(creditHistory);
            return ResponseEntity.ok(creditHistoryAfterUpdate);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"couldnt found credit history");
        }

    }
}
