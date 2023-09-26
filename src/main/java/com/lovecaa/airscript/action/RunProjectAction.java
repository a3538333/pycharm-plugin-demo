package com.lovecaa.airscript.action;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * toolwindow 运行按钮
 * 创建时间： 2023年08月06日 00:42:00
 *
 * @author Mr.Tao
 * @since 1.0.0
 */
public class RunProjectAction extends AnAction {


    public RunProjectAction() {
        super("运行", "RunProject", AllIcons.RunConfigurations.TestState.Run);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if (project != null) {
            System.out.println("-----------------Action------------------");
            System.out.println("projectBasePath:" + project.getBasePath());
            System.out.println("projectName:" + project.getName());
        }
    }

}
