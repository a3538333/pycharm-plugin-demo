package com.lovecaa.airscript.ui;

import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.impl.ActionToolbarImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class AirScriptToolWindow implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        System.out.println("init AirScriptToolWindow");
        System.out.println("projectBasePath:" + project.getBasePath());
        System.out.println("projectName:" + project.getName());
        JPanel panel = new JPanel(new BorderLayout());
        // 创建控制台组件
        ConsoleView consoleView = TextConsoleBuilderFactory.getInstance().createBuilder(project).getConsole();
        // 上面的toolbar
        panel.add(getTopToolPanel(project), BorderLayout.NORTH);
        // 控制台
        panel.add(consoleView.getComponent(), BorderLayout.CENTER);
        // 将主面板设置为 Tool Window 的内容
        toolWindow.setStripeTitle("AirScript");
        toolWindow.getContentManager().addContent(
                ContentFactory.getInstance().createContent(panel, "Console", false)
        );
    }


    /**
     * 获取顶部的工具栏面板
     *
     * @return 顶部的工具栏面板
     */
    public JPanel getTopToolPanel(Project project) {
        JPanel panel = new JPanel(new BorderLayout());
        AnAction runProjectAction = ActionManager.getInstance().getAction("AS_RunProject");
        DefaultActionGroup actionGroup = new DefaultActionGroup();
        actionGroup.add(runProjectAction);
        ActionToolbarImpl actionToolbar = new ActionToolbarImpl("AirScriptToolBar", actionGroup, true);
        actionToolbar.setTargetComponent(panel);
        actionToolbar.setActionButtonBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        panel.add(actionToolbar.getComponent(), BorderLayout.CENTER);
        return panel;
    }
}
