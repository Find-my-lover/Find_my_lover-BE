package com.gamjaring.web.springboot.controller;

import com.gamjaring.web.springboot.enumpack.Gender;
import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.filecontrol.S3FileComponent;
import com.gamjaring.web.springboot.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Api(tags={"ringmybell"})
@RestController(value = "/main")
@RequestMapping("/ringmybell")
@RequiredArgsConstructor
public class RingMyBellController {

    private final TestService testService;
    private final ResultsService resultsService;
    private final S3FileComponent s3FileComponent;
    private final UserService userService;


    @ApiOperation(value = "테스트실행")
    @PostMapping("/test")
    public ResponseEntity<?> select(@Valid @RequestParam String email,
                                    @Valid @RequestParam Gender gender,
                                    @Valid @RequestParam MultipartFile file) throws Exception {
        // TODO : 밑에서 로직 처리하는 부분을 service layer로 옮겨야 한다.
        //email로 사용자를 찾고 gender를 최신화하고 image를 저장한다.
        Member member = userService.getUser(email);
//        userServiceImpl.updateGender(email, gender);
//        imgServiceImpl.addMemberImg(member, file, email);
        testService.checkExist(member);
        testService.testLover(email, gender, file);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "1차 결과 출력")
    @GetMapping("/recommend")
    public List<String> recommend(@Valid @RequestParam String email) {

        Member member = userService.getUser(email);
        String partnerName = resultsService.getPartnerName(member);
        String coupleImageUrl = testService.getCouplePictureUrl(member);
        return Arrays.asList(partnerName, coupleImageUrl);
    }

    @ApiOperation(value = "나의 집 화면")
    @GetMapping("/results")
    public List<String> results(@Valid @RequestParam String email) {
        Member member = userService.getUser(email);
        List<String> resultUrls = resultsService.getResultPictureUrl(member);
        return resultUrls;
    }

    @ApiOperation(value = "사진 생성")
    @GetMapping("/photo")
    public String photo(@Valid @RequestParam String email) {

        Member member = userService.getUser(email);

        String url="http://127.0.0.1:5000/test_result";
        String sb="";

        try{
            HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
            BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line =null;
            while((line=br.readLine())!=null){
                sb=sb+line+'\n';
            }
            br.close();

            if(sb.toString().contains("ok")){
                return "api-axios complete";
                //return resultsService.getSelectPhotoListUrl(member);
            }
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
       //return resultsService.getSelectPhotoListUrl(member); // S3에 사진 18개를 모두 가지고 있어야 함
        return "errorPage/500";
    }

    @ApiOperation(value = "집 화면 커플 사진 커스텀 ")
    @PostMapping("/set-custom")
    public ResponseEntity<?> setCustom(@RequestParam int poseNum, @RequestParam int costumeNum) {
        resultsService.changeCustom(poseNum, costumeNum);
        return ResponseEntity.ok().build();
    }


    @ApiOperation(value = "다운로드테스트")
    @GetMapping("/download")
    public ResponseEntity<?> download(@RequestParam String filePath) throws IOException {
        return s3FileComponent.download(filePath);
    }

}
