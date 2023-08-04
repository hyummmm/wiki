package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.request.EbookRequest;
import com.jiawa.wiki.response.CommonResponse;
import com.jiawa.wiki.response.EbookResponse;
import com.jiawa.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResponse list(EbookRequest request) {
        CommonResponse<List<EbookResponse>> response = new CommonResponse<>();
        List<EbookResponse> list =  ebookService.list(request);
        response.setContent(list);
        return response;

    }

}
