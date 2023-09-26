package icons;

import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.AnimatedIcon;

import javax.swing.Icon;

/**
 * 图标库
 * 创建时间： 2023年06月18日 20:26:00
 *
 * @author Mr.Tao
 * @since 1.0.0
 */
public interface AirScriptIcons {
    // 16*16
    Icon ToolWindow = IconLoader.getIcon("toolwindow.svg", AirScriptIcons.class);
    Icon Loading = new AnimatedIcon.Default();

}
