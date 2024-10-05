package NASA.ExoFinder_BackEnd.web.controller;

import NASA.ExoFinder_BackEnd.service.CSVService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/csv")
public class CSVRestController {

    private final CSVService csvService;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public String upload(@RequestPart MultipartFile file) {
        try {
            csvService.saveCSVData(file);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
