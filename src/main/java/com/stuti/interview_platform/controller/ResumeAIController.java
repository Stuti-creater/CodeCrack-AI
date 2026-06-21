package com.stuti.interview_platform.controller;

import com.stuti.interview_platform.service.GroqService;
import com.stuti.interview_platform.service.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.web.multipart.MultipartFile;

@Controller
public class ResumeAIController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private GroqService groqService;
    private String latestResumeResult = "";

    @GetMapping("/resume-ai")
    public String resumeAI(){

        return "resume-ai";

    }

    @PostMapping("/resume-ai")
    public String analyzeResume(

            @RequestParam("resume")
            MultipartFile file,

            Model model

    ) throws Exception {

        String resumeText =
                resumeService.extractText(
                        file
                );

        String prompt = """

You are a senior FAANG recruiter and resume writer.

First analyze the resume.

Then rewrite it professionally.

Return EXACTLY in this format.

=================================================

⭐ RESUME ANALYSIS

Resume Score : x/10

ATS Score : x/100

Strengths

•

•

•

Weaknesses

•

•

•

Missing Skills

•

•

•

Suggestions

•

•

•

Recruiter Verdict

...

=================================================

✨ IMPROVED RESUME

Return the complete improved resume with these sections:

Name

Professional Summary

Skills

Projects

Education

Achievements

=================================================

Resume:

"""
+ resumeText;

        String result =
                groqService
                        .getInterviewFeedback(
                                prompt
                        );
                        latestResumeResult = result;

        model.addAttribute(
                "result",
                result
        );

        return "resume-ai";

    }
    
@PostMapping("/download-pdf")
public void downloadPdf(
        HttpServletResponse response
) throws Exception {

    Document document =
            new Document();

    response.setContentType(
            "application/pdf");

    response.setHeader(
            "Content-Disposition",
            "attachment; filename=ImprovedResume.pdf");

    PdfWriter.getInstance(
            document,
            response.getOutputStream()
    );

    document.open();

    document.add(
            new Paragraph(latestResumeResult)
    );

    document.close();
}
}