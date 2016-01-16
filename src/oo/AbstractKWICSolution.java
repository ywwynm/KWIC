package oo;

import general.Sentence;

import java.util.List;

/**
 * Created by 张启 on 2016/1/15.
 * 使用了模板方法设计模式
 */
public abstract class AbstractKWICSolution {

    protected abstract List<Sentence> input();
    protected abstract List<Sentence> prepare(List<Sentence> sentences);
    protected abstract List<Sentence> shift(List<Sentence> sentences);
    protected abstract void sort(List<Sentence> sentences);
    protected abstract void output(List<Sentence> sentences);

    public final void solveKWIC() {
        List<Sentence> sentences = input();
        sentences = prepare(sentences);
        sentences = shift(sentences);
        sort(sentences);
        output(sentences);
    }

}
