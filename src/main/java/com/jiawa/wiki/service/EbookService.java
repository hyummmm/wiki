package com.jiawa.wiki.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.domain.EbookExample;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.request.EbookRequest;
import com.jiawa.wiki.response.EbookResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResponse> list(EbookRequest request) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + request.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        List<EbookResponse> responseList = new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResponse ebookResponse = new EbookResponse();
            BeanUtils.copyProperties(ebook, ebookResponse);
            responseList.add(ebookResponse);
        }
        return responseList;
    }
}
