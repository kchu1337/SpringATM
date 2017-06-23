package Atm;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class TransactionController {

    @Autowired
    private ATMRepository atmRepository;

    private static String account;

    @RequestMapping("/")
    public String index(Model model) {
        account = "1234567";
        model.addAttribute("account", account);
        return "Index";
    }

    @RequestMapping("/deposit")
    public String loadDeposit(Model model) {
        model.addAttribute(new Transaction());
        model.addAttribute("page", "deposit");
        model.addAttribute("account", account);
        return "Deposit";
    }

    @RequestMapping("/withdraw")
    public String loadWithdraw(Model model) {
        model.addAttribute(new Transaction());
        model.addAttribute("page", "withdraw");
        model.addAttribute("account", account);
        return "Withdraw";
    }

    @RequestMapping("/depositSubmit")
    public @ResponseBody String deposit(@ModelAttribute Transaction transaction, Model model) {
        model.addAttribute("transaction",transaction);
        atmRepository.save(transaction);
        return "Done";
    }

    @RequestMapping("/withdrawSubmit")
    public @ResponseBody String withdraw(@ModelAttribute Transaction transaction, Model model) {
        transaction.setNeg();
        model.addAttribute("transaction",transaction);
        atmRepository.save(transaction);
        return "Done";
    }

    @RequestMapping("/history")
    public @ResponseBody String transactionHistory(@ModelAttribute Transaction transaction, Model model) {
        Iterable<Transaction> listOfTransactions = atmRepository.findAllByAccID(account);
        String output = "";
        for (Transaction trans : listOfTransactions){
            output += trans;
        }
        return output;
    }
}
