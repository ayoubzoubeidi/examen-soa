package tn.isi.banquecentrale.blacklist;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blacklist")
@RequiredArgsConstructor
public class BlackListController {

    private final BlackListService blackListService;

    @GetMapping("/{cin}")
    public ResponseEntity<?> isBlackList(@PathVariable String cin) {
        return new ResponseEntity<>(blackListService.isBlackList(cin), HttpStatus.OK);
    }

}
